var express = require('express')
var morgan = require('morgan')
var bodyParser = require('body-parser')

var hostname = 'localhost'
var port = 3000

var app = express()

app.use(morgan('dev'))
app.use(bodyParser.json())

app.all('/dishes', function(req, res, next) {
    res.writeHead(200, { 'Content-Type': 'text/html' })
    next()
})

app.get('/dishes', function(req, res, next) {
    res.end('will send all the dishes')
})

app.post('/dishes', function(req, res, next) {
    res.end(`will add the dished: ${req.body.name} with details: ${req.body.description}`)
})

app.delete('/dishes', function(req, res, next) {
    res.end('will delete all the dishes')
})

app.get('/dishes/:dishId', function(req, res, next) {
    res.end(`will send the dish: ${req.params.dishId}`)
})

app.put('/dishes/:dishId', function(req, res, next) {
    res.end(`update the dish: ${req.params.dishId} with detail: ${req.body.name}, ${req.body.description}`)
})

app.delete('/dishes/:dishId', function(req, res, next) {
    res.end(`delete dish: ${req.params.dishId}`)
})

app.use(express.static(__dirname + '/public'))

app.listen(port, hostname, function() {
    console.log(`server running at http://${hostname}:${port}`)
})
