function perimeter(x, y) {
    return 2 * (x + y)
}

function area(x, y) {
    return x * y
}

module.exports = {
    perimeter: perimeter,
    area: area,
    withCallback: function(x, y, callback) {
        try {
            if (x <= 0 || y <= 0) {
                throw new Error('x and y should be greater than 0')
            } else {
                callback(null, {
                    perimeter: perimeter,
                    area: area
                })
            }
        } catch (error) {
            callback(error)
        }
    }
}
