var mongoose = require('mongoose')
var assert = require('assert')

var Dishes = require('./models/dishes')

var url = 'mongodb://localhost:27017/conFusion'

mongoose.connect(url)
var db = mongoose.connection
db.on('error', console.error.bind(console, 'connection error: '))
db.once('open', function() {
    console.log('Connected correctly to server')

    var newDish = Dishes({
        name: 'UthaPizza',
        description: 'desc for UthaPizza',
        comments: [
            {
                rating: 4,
                comment: 'comment for UthaPizza',
                author: 'Jim'
            }
        ]
    })

    newDish.save(function(err) {
        if (err) { throw err }

        console.log('Dish created')

        Dishes.find({}, function(err, dishes) {
            if (err) { throw err }

            console.log('All Dishes: ', dishes)

            db.collection('dishes').drop(function() {
                db.close()
            })
        })
    })
})
