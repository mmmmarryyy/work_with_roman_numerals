/**
The regular expression `^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$` breaks down as follows:
- `^` and `$` match the start and end of the input string, respectively.
- `(M{0,3})` matches between zero and three occurrences of the letter "M".
- `(CM|CD|D?C{0,3})` matches one of three possibilities:
- "CM" for 900
- "CD" for 400
- "D" followed by between zero and three occurrences of the letter "C" for 500-800
- `(XC|XL|L?X{0,3})` matches one of three possibilities:
- "XC" for 90
- "XL" for 40
- "L" followed by between zero and three occurrences of the letter "X" for 50-80
- `(IX|IV|V?I{0,3})` matches one of three possibilities:
- "IX" for 9
- "IV" for 4
- "V" followed by between zero and three occurrences of the letter "I" for 5-8
**/
fun isValid(romanNumeral: String): Boolean {
    if (romanNumeral.isEmpty()) {
        throw IllegalArgumentException("String is empty (invalid roman numeral)")
    }
    if (romanNumeral.length > 15) {
        throw IllegalArgumentException("String contains more than 15 characters (invalid roman numeral)")
    }
    val romanNumeralRegex = "^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$".toRegex() //регулярное выражение, задающее римское число
    return romanNumeral.matches(romanNumeralRegex)
}

fun convert(romanNumeral: String): Int {
    if (romanNumeral.isEmpty()) {
        throw IllegalArgumentException("String is empty (invalid roman numeral)")
    }
    if (romanNumeral.length > 15) {
        throw IllegalArgumentException("String contains more than 15 characters (invalid roman numeral)")
    }
    if (!isValid(romanNumeral)) {
        throw IllegalArgumentException("String is not a roman numeral")
    }

    val map = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )

    var result = 0
    var previousChar = 0

    for (i in romanNumeral.indices.reversed()) {
        val currentChar = map[romanNumeral[i]] ?: throw IllegalArgumentException("Unexpected char (invalid roman numeral)")

        if (currentChar < previousChar) {
            result -= currentChar
        } else {
            result += currentChar
        }

        previousChar = currentChar
    }

    return result
}


fun main() {
    val romanNumeral = "MMMDCCCLXXXVIII" //3888
    println(isValid(romanNumeral)) //true
    println(romanNumeral.length) //15

    val arabic = convert("XXIV") // arabic = 24
    println(arabic)
}