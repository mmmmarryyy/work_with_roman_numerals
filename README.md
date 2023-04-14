# Work with roman numerals

## Русская версия

### Правила построения римских чисел

В римской системе счисления используются следующие знаки:
- I = 1
- V = 5
- X = 10
- L = 50
- C = 100
- D = 500
- M = 1000

Все целые числа от 1 до 3999 записываются с помощью приведенных выше цифр. При этом:
- если большая цифра стоит перед меньшей, они складываются:
  + VI = 5 + 1 = 6
  + XV = 10 + 5 = 15
  + LX = 50 + 10 = 60
  + CL = 100 + 50 = 150
- если меньшая цифра стоит перед большей (в этом случае она не может повторяться), то меньшая вычитается из большей; вычитаться могут только цифры, обозначающие 1 или степени 10; уменьшаемым может быть только цифра, ближайшая в числовом ряду к вычитаемой:
  + IV = 5 - 1 = 4
  + IX = 10 - 1 = 9
  + XL = 50 - 10 = 40
  + XC = 100 - 10 = 90
- цифры V, L, D не могут повторяться; цифры I, X, C, M могут повторяться не более трех раз подряд:
  + VIII = 8
  + LXXX = 80
  + DCCC = 800
  + MMMD = 3500

### Функционал

В файле [Main.kt](src/main/kotlin/Main.kt) реализованы две функции: 
- *isValid*, проверяющая валидность римского числа. Функция получает на вход строку, кидает *IllegalArgumentException*, если длина строки 0 или больше 15, иначе - возвращает *true*, если строка является римским числом, *false* - если не является
- *convert*, конвертирующая римское число в арабское. Функция получает на вход строку, кидает *IllegalArgumentException*, если строка не является римским числом или длина строки 0 или больше 15, иначе - возвращает арабское число, соответствующее входному римскому

## English version

### Rules for constructing Roman numerals

The following signs are used in the Roman numeral system:
- I = 1
- V = 5
- X = 10
- L = 50
- C = 100
- D = 500
- M = 1000

All integers from 1 to 3999 are written using the digits above. Wherein:
- if the larger number comes before the smaller one, they add up:
    + VI = 5 + 1 = 6
    + XV = 10 + 5 = 15
    + LX = 50 + 10 = 60
    + CL = 100 + 50 = 150
- if a smaller number comes before a larger one (in this case it cannot be repeated), then the smaller one is subtracted from the larger one; only numbers denoting 1 or powers of 10 can be subtracted; only the number closest in the number series to the subtrahend can be reduced:
    + IV = 5 - 1 = 4
    + IX = 10 - 1 = 9
    + XL = 50 - 10 = 40
    + XC = 100 - 10 = 90
- digits V, L, D cannot be repeated; digits I, X, C, M can be repeated no more than three times in a row:
    + VIII = 8
    + LXXX = 80
    + DCCC = 800
    + MMMD = 3500

### Functionality

The [Main.kt](src/main/kotlin/Main.kt) file implements two functions:
- *isValid* checking the validity of the Roman number. The function receives a string as input, throws *IllegalArgumentException* if the string length is 0 or more than 15, otherwise it returns *true* if the string is a Roman numeral, *false* if it is not
- *convert* converting Roman number to Arabic. The function receives a string as input, throws *IllegalArgumentException* if the string is not a Roman number or the string length is 0 or more than 15, otherwise it returns an Arabic number corresponding to the input Roman number