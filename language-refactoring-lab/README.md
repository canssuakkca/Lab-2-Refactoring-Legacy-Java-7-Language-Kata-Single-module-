Legacy Java SE 7 Language Refactoring Kata (refactor to Java 8 → 25)
======================================================

This is a single-module Java SE 7 codebase designed as a refactoring kata.
It intentionally uses pre-modern idioms: verbose generics, loops instead of streams,
manual resource management, nested if/else chains, instanceof casting, ExecutorService+Future, etc.

All code has been modernized **without changing behavior**. Key improvements include:

- Replaced loops with **streams and lambdas**  
- Used **try-with-resources** for safer file handling  
- Made model classes (**Order, OrderItem, Customer**) **immutable and validated**  
- Updated **DiscountPolicy** to a functional interface  
- Modernized **AsyncOrderProcessor** with streams and futures  
- Simplified **PaymentParser** using switch expressions  
- Added `toString`, `equals`, `hashCode` to key model classes  
- Improved **ReportRenderer** readability with streams  

Tests remain green, preserving original behavior.


Build & Run (baseline)
----------------------
mvn -q test
mvn -q package
java -jar target/legacy-java7-language-kata-1.0.0.jar src/main/resources/input/orders.csv

See EXERCISES.md for a version-by-version refactor backlog.
