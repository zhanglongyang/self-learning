var MongoClient = require('mongodb').MongoClient
var assert = require('assert')

var url = 'mongodb://localhost:27017/conFusion'

MongoClient.connect(url, function(err, db) {
    assert.equal(err, null)
    console.log('connecting to mongodb client correctly')

    var dishes = db.collection('dishes')
    dishes.insertOne({
        name: 'UthaPizza',
        description: 'desc for UthaPizza'
    }, function(err, result) {
        assert.equal(err, null)
        console.log('After Insert: ', result.ops)

        dishes.find({}).toArray(function(err, docs) {
            assert.equal(err, null)
            console.log('Found: ', docs)

            db.dropCollection('dishes', function(err, result) {
                assert.equal(err, null)
                db.close()
            })
        })
    })
})
