const liftA2 = (f) => (a, b) => a.map(f).ap(b)

const mult = a => b => a * b

const liftedMult = liftA2(mult)
liftedMult([1, 2], [3])
liftA2((a, b) => a + b)([1, 2], [3, 4])
