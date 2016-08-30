-- http://learnyouahaskell.com/starting-out

doubleMe x = x + x

doubleUs x y = x * 2 + y * 2

doubleUs2 x y = doubleMe x + doubleMe y

doubleSmallNumber x = if x > 100
  then x
  else x * 2
  
conanO'Brien = "It's a-me, Conan O'Brien!"

-- I'm a list comprehension