var express = require('express')
var bodyParser = require('body-parser')
var Dishes = require('../models/dishes')

var router = express.Router()

router.use(bodyParser.json())
router.route('/:dishId')
    .get(function(req, res, next) {
        Dishes.findById(req.params.dishId, function(err, dish) {
            if (err) { throw err }

            res.json(dish)
        })
    })
    .put(function(req, res, next) {
        Dishes.findByIdAndUpdate(req.params.dishId, {
            $set: req.body
        }, {
            new: true
        }, function(err, dish) {
            if (err) { throw err }

            res.json(dish)
        })
    })
    .delete(function(req, res, next) {
        Dishes.findByIdAndRemove(req.params.dishId, function(err, result) {
            if (err) { throw err }

            res.json(result)
        })
    })

router.route('/:dishId/comments')
    .get(function(req, res, next) {
        Dishes.findById(req.params.dishId, function(err, dish) {
            if (err) { throw err }

            res.json(dish.comments)
        })
    })
    .post(function(req, res, next) {
        Dishes.findById(req.params.dishId, function(err, dish) {
            if (err) { throw err }

            dish.comments.push(req.body)

            dish.save(function(err, dish) {
                if (err) { throw err }

                res.json(dish)
            })
        })
    })

module.exports = router
