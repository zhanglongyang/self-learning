var express = require('express')
var bodyParser = require('body-parser')
var Dishes = require('../models/dishes')

var router = express.Router()

router.use(bodyParser.json())
router.route('/:dishId')
    .get(function(req, res, next) {
        Dishes.find({}, function(err, dishes) {
            if (err) { throw err }
        })
        res.end('All dishes: ' + dishes)
    })
    .put(function(req, res, next) {
        Dishes.create(req.body, function(err, dish) {
            if (err) { throw err }

            console.log('Dish created!')
            res.writeHead(200, { 'Content-Type': 'text/plain' })

            res.end('Added the dish with id: ' + dish._id)
        })
    })
    .delete(function(req, res, next) {
        res.end('Deleting dish: ' + req.params.dishId)
    })

module.exports = router
