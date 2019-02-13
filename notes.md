## Things to Keep in Mind:
* Primative Data Types:
  - Sizes of whole numbers:
    - byte = 8 bits = -128 to 127 ... suffix: none
    - short = 16 bits ... suffix: none
    - int = 32 bits = -2,147,483,648 to 2,147,483,647 ... suffix: none
    - long = 64 bits ... suffix: `L` or `l` (ex 10_000_000_000L is fine)

  - Sizes of decimals:
    - float = 32 bits ... suffix `f` or `F`
    - double = 64 bits = approx ±1.79769313486231570E+308 ... suffix `d` or `D`

  - Note that `Char` can store integers, ex. `int i = 5` or `char c = '5'` are valid (but different numbers)
* Default Initialization:
  - byte: 0, short: 0, int: 0, long: 0L, float: 0.0f, double: 0.0, boolean: false, char: \u0000 
  - When printed on the console: byte, short, int & long prints 0, float & double print 0.0
* Object versions of primatives:
  - `Integer()` and `Double()` are siblings (both extends from Number class) so they can NOT be casted to each other
  - When declaring `Boolean()`, the values are not case-sensitive ... `Boolean("TrUE")` is OK
  - For the `Boolean()`, passing in `Boolean("true")` (or any case-insenstive "tRUE") gives `true`, otherwise you get `false`, so `Boolean("Ham Sandwich")` is `false`
  - Define new `Integer()` as `1` or `"1"`
  - `Integer() == Integer()` is NOT same as `Integer().equals()` ... same rules as Strings, use `.equals` to compare by value and `==` to check if it's the same object
  - BUT WAIT... Don't forget that weird work issue where if the int is < 127, then `new Integer(127) == new Integer(127)` (same for < -128) ... but then `new Integer(128) != new Integer(128)`
  - `Double()` can take in a number like `10.0` or `10` or a String like `"10"` or even a char (since that can be converted to `int` value... ex. `'a'` = `97`)
* Review rules on casting between different numbers
  - `float` can NOT be assigned to `int` without explicit casting
  - `double` can NOT be assigned to `int` without explicit casting
  - `double` can NOT be assigned to `float` without explicit casting
  - `int` can NOT be assigned to `byte` without explicit casting (unless, of course, u write it like this `byte b = 127` AND the number is small enough to be a byte... ex `byte b = 300` is NOT ok, this give compilation error)
  - `int` can NOT be assigned to `short` without explicit casting (unless, of course, u write it like  `short s = 32767` )

* Flow Control:
- Don't forget about Short circuiting of `&&` and `||` ... the `&` and `|` do NOT short circuit
- Always double check `switch` case values... Trick questions like  `int score = 60;switch (score); case score < 70:`. This is NOT ok b/c score is `int` but score < 70 is  `boolean`


* Strings:
- `substring(int beginIndex, int endIndex)` is used to extract the substring. The substring begins at "beginIndex" and extends to "endIndex - 1". 
- The `.toString` method works the same in String and Stringbuilder (shows the string, not the class@hashcode)
- StringBuilder class does NOT override `equals(Object)` method!!!
- Don't forget that Strings are immutable... common issue: `str1.trim();` will not change str1, need to do `str1 = str1.trim();`


* Arrays:
- Both are valid: `int[] myArr` or `int myArr[]` for an int array
- Warning: This is NOT valid... `double[] arr = new int[2];` ... `int[]` and `double[]` are NOT analagous to `int` and `double`
- outermost array length is `arr.length`, then get inner arrays with `arr[x].length`


* ArrayLists / Iterator:
-  If you want to remove the items from an ArrayList, while using Iterator or ListIterator, then use `Iterator.remove()` or method and NOT `ArrayList.remove()` method
- The method for `.addAll(1, list2);` inserts all values in list2 at index 1... doesn't delete anything... just slides over values.
- `List` is an interface so its instance can't be created using new keyword.
- Arraylist has `.remove(Object o)` (removes the first occurrence of obj) or `.remove(int i)` (removes by position)
- Using `.remove( new CustomObject("blah") )` might remove anything if the `.equals()` methods are not overridden, since hashcode of new object won't match those in the list
- `.remove(Object obj)` method returns boolean result but `.remove(int index)` returns the removed item from the list


* OOP:
- a Subtype can't refer to an object of Supertype, i.e. `(SubType) SuperTypeInstance()`; will throw ClassCastException.
- Possible to have abstract class without any abstract method
- Java compiler adds `super();` as the first statement inside a constructor if  acall to another constructor using this(...) or super(...) is not available.
- Using `.clone()` makes a shallow copy, objects contained in an ArrayList are not copied (just their references), primative are copied
- Yes, you can put access modifiers in front of constructors (yes, even `private` )
- TO call another constructor from within a constructor, you MUST use `this()`, you can NOT explicitly call `ObjectConstructorName()`!!!
- Automatic boxing of 10.0 can occur in `add(Double d1, Double d2)` for `add(10.0, new Double())`
- Yes, you can call on `super.methodName()` within child object
- Class declared as `final` can't be inherited. Examples are: String, Integer, System etc. Ex class `MyString extends String` is not OK since String is final
- Without `class Vehicle extends Car`, we will get a compilation error for `Vehicle obj = new Car();` ... and not an expection like classCastExpection
- A constructor should have `super()` or `this()`  but not both


* Exceptions:
- Checked Excpetions (i.e. anything that `throws` an Exception) requires a try / catch block
- The `try` block is only enough if the class it's inside of also `throws` the same checked exception, otherwise we, must have a `catch` for the specific checked exception
- There is no `ArrayIndexException`, that is FAKE... The correct one is `IndexOutOfBoundsException`
- Exceptions in `catch` blocks need to be handled in order... ex. `catch(FileNotFoundException){}` needs to come before `catch(IOException){}` since it extends the IOExpection
- Something like `catch(FileNotFoundException | IOException e)` is NOT ok if the 2 exceptions are sub / superclasses (as is the case in this example)
- If a super class / interface method `throws` a checked exception, then the overriding method of sub class can NOT declare to throw the super class of the exception thrown by super class / interface 

* Garbage Collector:
  - You can NOT "force" the JVM to run the Garbage Collector
  - But can "request" it to MAYBE get called using either: `System.gc();` or `Runtime.getRuntime().gc();`


* Lamdba Functions
- If using blocks (i.e. `{}`) then must have a `return` statement.
- Method to call on predicate function is `.test()`
- Be careful with `Predicate` vs `Predicate<String>` (or other types), the generic `Predicate` will assume type is `Object` so methods like `.length()` or `.size()` may not be useable


* Time/Date:
- The `.of()` must have a valid date or time, otherwise it gets an expection... Ex `LocalDate.of(2020, 2, 30)` will fail but if we had `add()` that got to that point, it would round down.
- Using `date.atTime(LocalTime)` method creates a LocalDateTime instance by combining date + time parts
- The `Period.of(0, 0, 0);` is same as `Period.ZERO`, it shows up as `P0D` (and NOT `P0Y0M0D`)
- Using `.parse()`, must be in `YYYY-MM-DD` format ... the `YYYY-M-DD` will not work
- LocalDate objects cannot use `==` to compare values, need to use `.equals()`
- Yes, `minusYears()` (and other times) can add/subtract negative values (i.e. `minusYears(-40)` is OK)
- Long chain of B.S. like this? `Period period = Period.of(2, 1, 0).ofMonths(5).ofDays(2);` ... only LAST thing (`ofDays()`) is valid since `Period` is a static method... Not to be confused with taking the 1st call
- Same as other objects, don't forget that `LocalDate != LocalDate`, use `.equals()` to compare by value
- Always be careful using right months (`LocalDate`) vs. minutes (`LocalTime`)
- Break down of the `.ofPattern("MM-DD-yy")` (capitialized = bigger letter = bigger number)
  - `MM` is MONTH
  - `mm` is minute
  - `DD` is DAY OF YEAR, 2 digit max (ex. Feb 3 is 34th day of year)
  - `DDD` is DAY OF YEAR, 3 digit max (ex. Dec 31th is 365th day (or 366th if leap year))
  - `dd` is day of month
  - `yy` is year (2 digit) and `yyyy` is year (4 digit). Note that `uu` and `uuuu` also work.
- Methods like `getMonth()` (singular) relate to LocalDate or LocalDateTime and `getMonths()` (plural) is for a `Period`


* Misc:
- A `static {}` block fires off before `public static void main(String[] args){}`
- As long as the others are not directly accessible by JVM, you can have more than 1 `main()` method (i.e. can't have 2+ public `main()` methods in 2 `public` classes)
- You can run a `public static void main()` method from a public or package-private class.
- Don't get tricked by methods that look like constructors... always check for `void` or other return type, then its method
- Package within a Package cannot access package-private field .. ex. if `com.test` has a package-private field then `com.test.A` cannot access it
- Yes, you can edit static fields using an object instance (but its not good practice)
- Note that `.length()` is NOT valid for arrays lengths, use `.length` for Arrays
- Note that `.length` is NOT valid for String lengths, use `.length()` for Strings
- Use `.size()` (and NOT `.length()`) for ArrayLists 
