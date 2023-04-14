import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class RomanNumeralsValidatorTest {
    @Test
    fun `isValid returns true for valid roman numerals`() {
        assertTrue(isValid("I"))
        assertTrue(isValid("IV"))
        assertTrue(isValid("V"))
        assertTrue(isValid("IX"))
        assertTrue(isValid("X"))
        assertTrue(isValid("XL"))
        assertTrue(isValid("L"))
        assertTrue(isValid("XC"))
        assertTrue(isValid("C"))
        assertTrue(isValid("CD"))
        assertTrue(isValid("D"))
        assertTrue(isValid("CM"))
        assertTrue(isValid("M"))
        assertTrue(isValid("MMXXI"))
    }

    @Test
    fun `isValid returns false for invalid roman numerals`() {
        assertFalse(isValid("IIII"))
        assertFalse(isValid("VV"))
        assertFalse(isValid("LL"))
        assertFalse(isValid("DD"))
        assertFalse(isValid("XXXX"))
        assertFalse(isValid("CCCC"))
        assertFalse(isValid("MMMM"))
        assertFalse(isValid("XM"))
        assertFalse(isValid("LC"))
        assertFalse(isValid("DM"))
        assertFalse(isValid("IM"))
    }

    @Test
    fun `isValid returns false for input containing non-Roman numeral characters`() {
        assertFalse(isValid("IIIA"))
        assertFalse(isValid("VX"))
        assertFalse(isValid("XZM"))
        assertFalse(isValid("MCMXIX1"))
        assertFalse(isValid("MMXII I"))
    }

    @Test
    fun `isValid returns false for input with incorrect order of Roman numerals`() {
        assertFalse(isValid("VX"))
        assertFalse(isValid("IL"))
        assertFalse(isValid("IC"))
        assertFalse(isValid("ID"))
        assertFalse(isValid("IM"))
        assertFalse(isValid("XD"))
        assertFalse(isValid("XM"))
        assertFalse(isValid("LC"))
        assertFalse(isValid("DM"))
    }

    @Test
    fun `isValid throws IllegalArgumentException for empty input`() {
        assertThrows(IllegalArgumentException::class.java) {
            isValid("")
        }
    }

    @Test
    fun `isValid throws IllegalArgumentException for input with too long length`() {
        assertThrows(IllegalArgumentException::class.java) {
            isValid("MMMCCCDDDLLLXXXIII")
        }
    }

    @Test
    fun `isValid returns false for input containing more than three consecutive identical Roman numerals`() {
        assertFalse(isValid("IIII"))
        assertFalse(isValid("XXXXX"))
        assertFalse(isValid("CCCCC"))
        assertFalse(isValid("MMMMM"))
    }

    @Test
    fun `isValid returns false for input with invalid subtractive notation`() {
        assertFalse(isValid("VX"))
        assertFalse(isValid("VL"))
        assertFalse(isValid("VC"))
        assertFalse(isValid("VD"))
        assertFalse(isValid("VM"))
        assertFalse(isValid("XD"))
        assertFalse(isValid("XМ"))
        assertFalse(isValid("IL"))
        assertFalse(isValid("IC"))
        assertFalse(isValid("ID"))
        assertFalse(isValid("IM"))
    }

    @Test
    fun `isValid returns false for input containing more than one occurrence of a subtractive notation`() {
        assertFalse(isValid("IIL"))
        assertFalse(isValid("IIC"))
        assertFalse(isValid("IID"))
        assertFalse(isValid("IIM"))
        assertFalse(isValid("XXD"))
        assertFalse(isValid("XXM"))
        assertFalse(isValid("LLC"))
        assertFalse(isValid("LLD"))
        assertFalse(isValid("LLM"))
        assertFalse(isValid("DDM"))
    }
}

class RomanToArabicTest {

    @Test
    fun `convert works correctly on valid input`() {
        assertEquals(1, convert("I"))
        assertEquals(4, convert("IV"))
        assertEquals(9, convert("IX"))
        assertEquals(40, convert("XL"))
        assertEquals(88, convert("LXXXVIII"))
        assertEquals(90, convert("XC"))
        assertEquals(400, convert("CD"))
        assertEquals(567, convert("DLXVII"))
        assertEquals(900, convert("CM"))
        assertEquals(2023, convert("MMXXIII"))
        assertEquals(3488, convert("MMMCDLXXXVIII"))
        assertEquals(3999, convert("MMMCMXCIX"))
    }

    @Test
    fun `convert throws IlegalArgumentException on invalid input (input is not a roman numeral)`() {
        assertThrows(IllegalArgumentException::class.java) {
            convert("ABC")
        }
        assertThrows(IllegalArgumentException::class.java) {
            convert("IIII")
        }
        assertThrows(IllegalArgumentException::class.java) {
            convert("VV")
        }
        assertThrows(IllegalArgumentException::class.java) {
            convert("XXL")
        }
        assertThrows(IllegalArgumentException::class.java) {
            convert("MMMMM")
        }
        assertThrows(IllegalArgumentException::class.java) {
            convert("MMMMCMXCIX")
        }
        assertThrows(IllegalArgumentException::class.java) {
            convert("IIII")
        }
        assertThrows(IllegalArgumentException::class.java) {
            convert("VV")
        }
        assertThrows(IllegalArgumentException::class.java) {
            convert("LL")
        }
        assertThrows(IllegalArgumentException::class.java) {
            convert("DD")
        }
        assertThrows(IllegalArgumentException::class.java) {
            convert("XXXX")
        }
        assertThrows(IllegalArgumentException::class.java) {
            convert("CCCC")
        }
        assertThrows(IllegalArgumentException::class.java) {
            convert("MMMM")
        }
        assertThrows(IllegalArgumentException::class.java) {
            convert("XM")
        }
        assertThrows(IllegalArgumentException::class.java) {
            convert("LC")
        }
        assertThrows(IllegalArgumentException::class.java) {
            convert("DM")
        }
        assertThrows(IllegalArgumentException::class.java) {
            convert("IM")
        }
    }

    @Test
    fun `test edge cases`() {
        assertThrows(IllegalArgumentException::class.java) {
            convert("") //string with 0 characters
        }
        assertEquals(1, convert("I")) //min roman numeral + min number of characters
        assertEquals(3888, convert("MMMDCCCLXXXVIII")) //mac (15) number of characters
        assertEquals(3999, convert("MMMCMXCIX")) //max roman numeral
        assertThrows(IllegalArgumentException::class.java) {
            convert("MMMDCCCLXXXVIIII") //more than 15 characters
        }
    }
}

class RomanToArabicParametrizedTest {

    @ParameterizedTest
    @CsvSource(
        "I, 1",
        "IV, 4",
        "IX, 9",
        "XL, 40",
        "XC, 90",
        "CD, 400",
        "DXCIII, 593",
        "CM, 900",
        "MMMDCLXXXVII, 3687",
        "MMMCMXCIX, 3999"
    )
    fun `test valid input`(input: String, expected: Int) {
        assertEquals(expected, convert(input))
    }

    @ParameterizedTest
    @CsvSource(
        "ABC",
        "IIII",
        "VV",
        "XXL",
        "MMMMMM",
        "MMMMCMXCIX"
    )
    fun `test invalid input`(input: String) {
        assertThrows(IllegalArgumentException::class.java) {
            convert(input)
        }
    }
}

class RomanNumeralValidatorParametrizedTest {

    @ParameterizedTest
    @ValueSource(
        strings = ["I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C", "CC", "CCC", "CD",
            "D", "DC", "DCC", "DCCC", "CM", "M", "MM", "MMM"]
    )
    fun `test isValidRomanNumeral with valid input`(input: String) {
        assertEquals(true, isValid(input))
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["IIII", "XXXX", "CCCC", "MMMM", "VV", "LL", "DD",
            "XM", "IM", "ID", "IC", "IL", "XD", "VL"]
    )
    fun `test isValidRomanNumeral with invalid input`(input: String) {
        assertEquals(false, isValid(input))
    }
}