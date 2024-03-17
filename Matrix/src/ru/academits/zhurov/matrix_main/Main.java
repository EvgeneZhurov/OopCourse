package ru.academits.zhurov.matrix_main;

import ru.academits.zhurov.vector.Vector;
import ru.academits.zhurov.matrix.Matrix;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(2, 3);
        System.out.println(matrix.getStringsQuantity());
        System.out.println("Проверка конструктора " + matrix);

        double[][] array = {{1, 2, 3}, {4, 5, 6}};
        Matrix matrix2 = new Matrix(array);
        System.out.println("Проверка конструктора " + matrix2);

        Vector vector = matrix2.getRow(0);
        System.out.println("Проверка метода getVectorRow " + vector);

        matrix2.setScalarMultiplication(2);
        System.out.println("Проверка метода setScalarMultiplication " + matrix2);

        matrix2.setTransposition();
        System.out.println("Проверка метода setTransposition " + matrix2);

        double[][] array1 = {{1, 2}, {4, 5}};
        Matrix matrix3 = new Matrix(array1);
        System.out.println("Определитель матрицы = " + matrix3.getDeterminant());

        Vector vector4 = new Vector(new double[]{5, 6, 7});
        Vector vector5 = matrix2.getVectorMultiplying(vector4);
        System.out.println("Умножение матрицы на вектор " + vector5);

        double[][] array4 = {{1, 2}, {4, 5}};
        Matrix matrix4 = new Matrix(array4);

        double[][] array5 = {{10, 20}, {40, 50}};
        Matrix matrix5 = new Matrix(array5);

        matrix4.addSum(matrix5);
        System.out.println("Сложение матриц: " + matrix4);

        matrix4.setMatrixSubtraction(matrix5);
        System.out.println("Вычитание матриц: " + matrix4);

        double[][] array6 = {{1, 2}, {4, 5}};
        Matrix matrix6 = new Matrix(array6);

        double[][] array7 = {{10, 20, 30}, {40, 50, 60}};
        Matrix matrix7 = new Matrix(array7);

        Matrix matrix8 = Matrix.getComposition(matrix6, matrix7);
        System.out.println("Произведение матриц: " + matrix8);
    }
}

/*    Добрый вечер!
        2. Аргументы конструкторов и методов нужно проверять на корректность.
        Если они некорректные, то нужно бросать исключение

        5. Matrix(int row, int column):
        - new Vector(new double[row]) - не нужно создавать временный массив, который потом не используется.
        Здесь нужно использовать конструктор вектора, принимающий размерность вектора
        - http://joxi.ru/rJjDEYoHkKwdGr - эта логика неправильная, сейчас создается один вектор, и все элементы массива ссылаются на него.
        Поэтому если изменить одну строку матрицы, то изменятся все строки - это неправильно.
        Для каждой строки нужно создать свой объект

        6. Matrix(Matrix matrix) - сейчас в новую матрицу присваивается ссылка на массив переданной исходной матрицы.
        Поэтому если изменить исходную матрицу, то изменится и новая матрица.
        Так быть не должно, нужно создавать новый массив с копиями строк исходной матрицы

        7. Matrix(Vector[] array):
        - сейчас в новую матрицу присваивается ссылка на внешний массив.
        Поэтому если изменить этот массив снаружи, то изменится и матрица.
        Так быть не должно, нужно создавать копию массива
        - конструкторы не должны позволять создать матрицу размера 0
        - векторы в массиве могут иметь разную размерность.
        Нужно сделать, чтобы в итоговой матрице количество столбцов было равно количеству элементов в векторе наибольшей размерности
        - здесь array лучше назвать vectors

        8. Matrix(double[][] array):
        - matrix - нужно обойтись без создания дополнительного объекта матрицы, который потом не используется.
        Здесь достаточно создавать массив строк
        - здесь лучше использовать конструктор вектора, принимающий массив значений и размерность вектора

        12. setVectorRow, getVectorRow, getVectorColumn:
        - column - имя аргумента неинформативное и для некоторых из этих методов неправильное.
        По смыслу это индекс, в одних методах это индекс строки, в других индекс столбца
        - проверка индекса для индексов строк и для индексов столбцов должна быть разной, т.к. матрица не обязательно квадратная
        - сейчас проверка выхода индекса за верхнюю границу неправильная
        - здесь для выхода индекса за обе границы лучше бросать одно исключение, но с более информативным сообщением
        - в сообщении исключения для индекса лучше также указывать само значение индекса и значения обеих границ, это упростит отладку
        - "Столбец должен быть неотрицательной величиной" - сообщение неправильное, т.к. здесь не столбец, а индекс столбца
        - геттер лучше объявлять выше соответствующего сеттера

        13. setVectorRow:
        - должна быть проверка, что переданный вектор ровно нужного размера, иначе нужно бросать исключение
        - сейчас строке матрицы присваивается ссылка на переданный вектор (аргумент).
        Если этот вектор изменится, то изменится и матрица.
        Такого быть не должно, нужно присваивать копию

        14. setTransposition:
        - сейчас по имени кажется, что это сеттер поля transposition, но такого поля нет
        - вместо имени "установить транспонирование" должно быть имя "транспонировать"
        - сейчас создается матрица той же размерности, что и текущая, поэтому метод падает
        - нужно обойтись без создания новой матрицы, здесь достаточно создать новый массив
        - здесь не нужно использовать setVectorRow, нужно работать с самим массивом строк

        15. toString:
        - по заданию список элементов матрицы нужно печатать в фигурных скобках
        - нужно сделать полностью самим через StringBuilder

        16. equals - лучше использовать Arrays.equals

        17. setScalarMultiplication(double multiplier):
        - сейчас по имени кажется, что это сеттер поля scalarMultiplication, но такого поля нет
        - имя неправильное, т.к. это не метод скалярного произведения, а метод умножения матрицы на скаляр.
        Поэтому должно быть имя "умножить на скаляр"
        - vector - лучше назвать "строка", т.к. по смыслу это строка матрицы

        18. getDeterminant():
        - http://joxi.ru/2Q4dWQlc4XwYkm - лишний пробел в сообщении
        - в сообщении исключения лучше указать оба сравниваемых значения, это упростит отладку
        - если матрица не квадратная, вместо IllegalArgumentException для определителя лучше использовать UnsupportedOperationException, т.к. у метода нет аргумента
        - getVectorColumn(0).getComponent(0) и др. - здесь неэффективно использовать getVectorColumn или getVectorRow, т.к. они создают новый вектор.
        Нужно обращаться напрямую к элементам массива строк матрицы
        - http://joxi.ru/2pnoM1xcjz7Kor - сейчас цикл сделан неэффективно.
        Внешний цикл должен проходить по строкам матрицы, а внутренний по столбцам, т.к. индекс строки является самым внешним (самым левым) индексом массива

        19. getMatrixDeterminant(double[][] matrix):
        - имя лучше сократить до getDeterminant
        - matrix.length - 1 - значение выражения заново вычисляется с одинаковыми аргументами на каждой итерации цикла.
        В таком случае лучше завести переменную и вычислить ее значение до начала цикла

        20. getVectorMultiplying(Vector vector):
        - вместо "получить умножение вектора" (получить действие), должно быть либо "получить произведение", либо "умножить на вектор"
        - в сообщении исключения лучше указать оба сравниваемых значения, это упростит отладку
        - vectorMultiplying - вместо "умножение вектора" должно быть имя "вектор произведения" (произведение - результат умножения) или "произведение"
        - в текущей версии: здесь удобнее сделать массив чисел и работать с ним, а потом на основе него создать вектор.
        Этот подпункт можно не исправлять
        - можно использовать скалярное произведение
        - есть ошибки

        21. Нестатические setMatrixSum и setMatrixSubtraction:
        - сейчас по именам кажется, что это сеттеры полей, но таких полей в матрице нет
        - слово Matrix избыточно, т.к. метод и так вызывается от объекта класса Matrix
        - должны быть имена "прибавить" и "вычесть"
        - matrix.getColumnLength() - внутри класса есть прямой доступ к полям объектов того же класса, поэтому не нужно использовать геттер
        - в сообщении исключения нужно указать все сравниваемые размеры обеих матриц, это упростит отладку
        - проверку равенства размеров нужно вынести во вспомогательный метод, чтобы не дублировать код
        - здесь неправильно использовать getVectorRow и setVectorRow, т.к. они должны создавать копии векторов, которые здесь не нужны.
        Здесь нужно обращаться напрямую к массивам строк обеих матриц
        - в текущей версии в setMatrixSubtraction не нужно использовать setRevers и setSum нужно использовать метод вычитания вектора
        - сейчас есть много лишнего кода, здесь нужно использовать нестатические методы прибавления/вычитания самих векторов из массива строк матрицы, тогда код упростится

        22. Статические getMatrixSum и getMatrixSubtraction:
        - слово Matrix в именах - либо неправильный порядок слов (матрица суммы), либо слово должно быть во множественном числе (сумма матриц).
        В целом, это слово избыточно в обоих случаях, поэтому его лучше удалить
        - вместо "получить вычитание" (получить действие) должно быть имя "получить разность" (т.е. получить результат вычитания)
        - matrix1.getColumnLength(), matrix2.getColumnLength() - внутри класса есть прямой доступ к полям объектов того же класса, поэтому не нужно использовать геттер
        - в сообщении исключения нужно указать все сравниваемые размеры обеих матриц, это упростит отладку
        - проверку равенства размеров нужно вынести во вспомогательный метод, чтобы не дублировать код
        - matrixSubtraction - имя неправильное по смыслу для суммы матриц
        - subtraction - вместо имени "вычитание" (действие) должно быть имя "разность" (результат вычитания, т.е. результат действия)
        - нужно использовать соответствующие нестатические методы матрицы, чтобы не дублировать код

        23. Статический getMatrixMultiplication (//исправлено на getComposition):
        - matrix1.getVectorRow(i)//( сейчас matrix1.getRow(i)) - здесь неэффективно использовать геттер, т.к. он создает копию, которая здесь не нужна.
        Нужно обращаться к самому массиву строк матрицы
 */
