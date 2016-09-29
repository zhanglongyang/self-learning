const compose = (f, g) => (a) => f(g(a))

const floorAndToString = compose((val) => val.toString, Math.floor)
floorAndToString(123.3333)
