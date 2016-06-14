var express = require('express')
var bodyParser = require('body-parser')
var Dishes = require('../models/dishes')

var router = express.Router()

router.use(bodyParser.json())
router.route('/')
    .get(function(req, res, next) {
        Dishes.find({}, function(err, dishes) {
            if (err) { throw err }

            res.json(dishes)
        })
    })
    .post(function(req, res, next) {
        Dishes.create(req.body, function(err, dish) {
            if (err) { throw err }

            console.log('Dish created!')
            res.writeHead(200, { 'Content-Type': 'text/plain' })

            res.end('Added the dish with id: ' + dish._id)
        })
    })
    .delete(function(req, res, next) {
        Dishes.delete({}, function(err, result) {
            if (err) { throw err }

            res.json(result)
        })
    })

module.exports = router
