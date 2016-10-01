[![Build status](https://travis-ci.org/fpinscala/fpinscala.svg?branch=master)](https://travis-ci.org/fpinscala/fpinscala)

This repository contains exercises, hints, and answers for the book [Functional Programming in Scala](http://manning.com/bjarnason/). Along with the book itself, it's the closest you'll get to having your own private functional programming tutor without actually having one.

Here's how to use this repository:

Each chapter in the book develops a fully working library of functions and data types, built up through a series of exercises and example code given in the book text. The shell of this working library and exercise stubs live in `exercises/src/main/scala/fpinscala/<chapter-description>`, where `<chapter-description>` is a package name that corresponds to the chapter title (see below). When you begin working on a chapter, we recommend you open the exercise file(s) for that chapter, and when you encounter exercises, implement them in the exercises file and make sure they work.

If you get stuck on an exercise, let's say exercise 4 in the chapter, you can find hints in `answerkey/<chapter-description>/04.hint.txt` (if no hints are available for a problem, the file will just have a single '-' as its contents) and the answer along with an explanation of the answer and any variations in `answerkey/<chapter-description>/04.answer.scala` or `04.answer.markdown`. The finished Scala modules, with all answers for each chapter live in `answers/src/main/scala/fpinscala/<chapter-description>`. Please feel free to submit pull requests for alternate answers, improved hints, and so on, so we can make this repo the very best resource for people working through the book.

Chapter descriptions:

* [Chapter 1: What is functional programming?](https://github.com/fpinscala/fpinscala/wiki/Chapter-1:-What-is-functional-programming%3F)
* [Chapter 2: Getting started](https://github.com/fpinscala/fpinscala/wiki/Chapter-2:-Getting-started)
* [Chapter 3: Functional data structures](https://github.com/fpinscala/fpinscala/wiki/Chapter-3:-Functional-data-structures)
* [Chapter 4: Handling errors without exceptions](https://github.com/fpinscala/fpinscala/wiki/Chapter-4:-Handling-errors-without-exceptions)
* [Chapter 5: Strictness and laziness](https://github.com/fpinscala/fpinscala/wiki/Chapter-5:-Strictness-and-laziness)
* [Chapter 6: Purely functional state](https://github.com/fpinscala/fpinscala/wiki/Chapter-6:-Purely-functional-state)
* [Chapter 7: Purely functional parallelism](https://github.com/fpinscala/fpinscala/wiki/Chapter-7:-Purely-functional-parallelism)
* [Chapter 8: Property-based testing](https://github.com/fpinscala/fpinscala/wiki/Chapter-8:-Property-based-testing)
* [Chapter 9: Parser combinators](https://github.com/fpinscala/fpinscala/wiki/Chapter-9:-Parser-combinators)
* [Chapter 10: Monoids](https://github.com/fpinscala/fpinscala/wiki/Chapter-10:-Monoids)
* [Chapter 11: Monads](https://github.com/fpinscala/fpinscala/wiki/Chapter-11:-Monads)
* [Chapter 12: Applicative and traversable functors](https://github.com/fpinscala/fpinscala/wiki/Chapter-12:-Applicative-and-traversable-functors)
* [Chapter 13: External effects and I/O](https://github.com/fpinscala/fpinscala/wiki/Chapter-13:-External-effects-and-IO)
* [Chapter 14: Local effects and mutable state](https://github.com/fpinscala/fpinscala/wiki/Chapter-14:-Local-effects-and-mutable-state)
* [Chapter 15: Stream processing and incremental I/O](https://github.com/fpinscala/fpinscala/wiki/Chapter-15:-Stream-processing-and-incremental-IO)

To build the code for the first time, if on windows:

    $ .\sbt.cmd

If on mac/linux, first make sure you have not checked out the code onto an encrypted file system, otherwise you will get compile errors regarding too long file names (one solution is to put the fpinscala repo on a unencrypted usb key, and symlink it into your preferred code location).

    $ chmod a+x ./sbt
    $ ./sbt

This will download and launch [sbt](http://scala-sbt.org), a build tool for Scala. Once it is finished downloading, you'll get a prompt from which you can issue commands to build and interact with your code. Try the following:

    > project exercises
    > compile

This switches to the exercises project, where your code lives, and compiles the code. You can also do:

    > console

to get a Scala REPL with access to your exercises, and

    > run

To get a menu of possible main methods to execute.

To create project files for the eclipse IDE you can install the [sbteclipse](https://github.com/typesafehub/sbteclipse) [sbt](http://scala-sbt.org) plugin.
This makes a new command available in [sbt](http://scala-sbt.org):

    > eclipse

All code in this repository is [MIT-licensed](http://opensource.org/licenses/mit-license.php). See the LICENSE file for details.

Have fun, and good luck! Also be sure to check out [the community wiki](https://github.com/fpinscala/fpinscala/wiki) for the **chapter notes**, links to more reading, and more.

_Paul and Rúnar_
