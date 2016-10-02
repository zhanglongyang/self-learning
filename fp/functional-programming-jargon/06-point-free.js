const map = (fn) => (list) => list.map(fn)
const add = (a) => (b) => a + b

const incrementAll = (numbers) => map(add(1))(numbers)
const incrementAll2 = map(add(a1))
