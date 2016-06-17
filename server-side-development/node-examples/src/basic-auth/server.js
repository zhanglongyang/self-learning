var express = require('express')
var morgan = require('morgan')

var hostname = 'localhost'
var port = 3000

var app = express()
app.use(morgan('dev'))

function auth(req, res, next) {
    var authHeader = req.headers.authorization

    if (!authHeader) {
        var err = new Error('You are not authenticated')
        err.status = 401
        next(err)
        return
    }
}

app.use(express.static(__dirname + '/public'))
app.listen(port, hostname, function() {
    console.log(`server running at http://${hostname}:${port}`)
})
