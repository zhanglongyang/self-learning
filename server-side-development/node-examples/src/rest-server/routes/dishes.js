var express = require('express')
var bodyParser = require('body-parser')

var router = express.Router()

router.use(bodyParser.json())
router.route('/')
    .all(function(req, res, next) {
        res.writeHead(200, { 'Content-Type': 'text/plain' })
        next()
    })
    .get(function(req, res, next) {
        res.end('get dish')
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
router.route('/:dishId')
    .all(function(req, res, next) {
        res.writeHead(200, { 'Content-Type': 'text/plain' })
        next()
    })
    .get(function(req, res, next) {
        res.end('Will send details of the dish: ' + req.params.dishId +' to you!')
    })
    .put(function(req, res, next) {
        res.write('Updating the dish: ' + req.params.dishId + '\n')
        res.end('Will update the dish: ' + req.body.name + ' with details: ' + req.body.description)
    })
    .delete(function(req, res, next) {
        res.end('Deleting dish: ' + req.params.dishId)
    })
