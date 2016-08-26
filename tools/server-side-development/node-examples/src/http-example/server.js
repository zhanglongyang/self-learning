var http = require('http')
var fs = require('fs')
var path = require('path')

var hostname = 'localhost'
var port = 3000

var server = http.createServer(function(req, res) {
    // console.log(req.headers)
    //
    // res.writeHead(200, { 'Content-Type': 'text/html' })
    // res.end('<h1>Hello World!</h1>')

    console.log(`request url: ${req.url} method: ${req.method}`)

    if (req.method === 'GET') {
        var fileUrl = req.url === '/' ? 'index.html' : req.url
        var filePath = path.resolve('./public/' + fileUrl)
        var fileExt = path.extname(filePath)

        if (fileExt === '.html') {
            fs.exists(filePath, function(exists) {
                if (!exists) {
                    res.writeHead(404, { 'Content-Type': 'text/html' })
                    res.end(`<h1>error: ${fileUrl} not found`)
                } else {
                    res.writeHead(200, { 'Content-Type': 'text/html' })
                    fs.createReadStream(filePath).pipe(res)
                }
            })
        } else {
            res.writeHead(404, { 'Content-Type': 'text/html' })
            res.end(`<h1>error: ${fileUrl} is not html`)
        }
    }
})

server.listen(port, hostname, function() {
    console.log(`server running at http://${hostname}:${port}`)
})
