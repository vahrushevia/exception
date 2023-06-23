# Урок 1. Обработка ошибок в программировании
## 1. Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
## 2. Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить? 
```
public static int sum2d(String[][] arr)
{ 
    int sum = 0; 
    for (int i = 0; i < arr.length; i++) 
    { 
        for (int j = 0; j < 5; j++) 
        { 
            int val = Integer.parseInt(arr[i][j]); 
            sum += val; 
        } 
    } 
    return sum; 
} 
```
## ответ задание №2
* __NumberFormatException__: возникает, если строка, которую мы пытаемся преобразовать в целое число с помощью метода Integer.parseInt(), имеет неправильный формат и не может быть преобразована в число. Это может произойти, если в ячейке arr[i][j] находится нечисловое значение или пустая строка.

* __ArrayIndexOutOfBoundsException__: может возникнуть, если значения переменных i и j выходят за пределы допустимого диапазона индексов массива arr. Например, если arr имеет размерность [3][5], а мы пытаемся обратиться к элементу arr[3][0] или arr[2][5], возникнет исключение.

* __NullPointerException__: возникает, если переменная arr является нулевой ссылкой (null), а мы пытаемся обратиться к ее элементам. Если arr не инициализирована или имеет значение null, возникнет исключение.

## 3. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя. Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше

# Урок 2. Исключения и их обработка
## 1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
## 2. Если необходимо, исправьте данный код (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
## 3. Дан следующий код, исправьте его там, где требуется (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
## 4. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно показаться сообщение, что пустые строки вводить нельзя. Далее запросить повторный ввод строки

# Урок 3. Продвинутая работа с исключениями в Java
Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
ФИО, дата рождения, номер телефона, пол

Форматы данных:
фамилия, имя, отчество - строки
дата рождения - строка формата dd.mm.yyyy
номер телефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше или больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java или создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида

<Фамилия><Имя><Отчество><дата рождения> <номер телефона><пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.