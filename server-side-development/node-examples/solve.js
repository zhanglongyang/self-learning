var rect = require('./rectangle')

function solveRect(l, b) {
    console.log('resolving for rectangle width l = ' + l + ' and b = ' + b)

    if (l <= 0 || b <= 0) {
        console.log('l or b must be greater than 0')
    } else {
        console.log('perimeter is ', rect.perimeter(l, b))
        console.log('area is ', rect.area(l, b))
    }

}

solveRect(2, 4)
solveRect(3, 5)
solveRect(-3, 5)
