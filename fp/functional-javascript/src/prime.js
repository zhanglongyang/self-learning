var R = require('ramda');

function isPrime(n) {
    var possibalFactors = R.range(2, n - 1);

    var hasFactor = R.any(isFactorOf(n), possibalFactors);

    return !hasFactor;
}

var isFactorOf = R.curry(function(n, factor) {
    return n % factor === 0;
});

module.exports = {
    isPrime: isPrime
};
