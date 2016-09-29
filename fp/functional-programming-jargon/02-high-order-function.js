const filter = (predicate, xs) => {
  const result = []
  for (let idx = 0; idx < xs.length; idx++) {
    if (predicate(xs[idx]) {
        result.push(xs[idx])
      })
  }
  return result
}

const is = (type) => (x) => Object(x) instanceof type

filter(is(Number), [0, '1', 2, null])
