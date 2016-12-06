## Functional Programming in Scala

Welcome to my code, which follows along with the
*Functional Programming in Scala* textbook's code and exercises.

In this repositry, I try to use the `scalatest` library to unit-test all my
functional code as I write it, and in the process get used to a more
professional scala dev environment

The code is organized into files by section; some files cover more than one
section, in which case the file is named based on the first section it
covers.

## Contents

# Chapter 2

There are three main + test modules in Chapter 2
  - `Ch02s04` has introductory examples (fibbonacci and factorial functions),
    The test code includes examples of both scalatest `Spec`-driven
    testing and using the java `TestNG` library via scalatest.
  - `Ch02s05` has introductory examples of polymorphism and higher-order
    functions: using predicates for sorting and finding elements of Arrays
    in a generic way. There's also an extra example in there from prior to
    me using test-driven development that shows how to do generic programming
    via the `Numeric` trait
  - `Ch02s06` has some classic functional examples: partials, currying,
     uncurring, and composing functions
