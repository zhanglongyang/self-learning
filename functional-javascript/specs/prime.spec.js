var Prime = require('../src/prime');

describe('Prime', function() {
    describe('isPrime', function() {
        it('should be satisfied if a number is Prime', function() {
            expect(Prime.isPrime(2)).toBe(true);
            expect(Prime.isPrime(4)).toBe(false);
        });
    });
});
