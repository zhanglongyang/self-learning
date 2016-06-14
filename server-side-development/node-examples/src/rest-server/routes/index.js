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
        res.end('post dish')
    })
    .delete(function(req, res, next) {
        res.end('delete dish')
    })
    .put(function(req, res, next) {
        res.end('put dish')
    })

module.exports = router
