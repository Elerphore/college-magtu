<?php
abstract class FlexibleCalc
{
    //Классические вычисления в PHP
    const TYPE_CLASSIC = 10;

    //Вычисления через GMP
    const TYPE_GMP     = 20;

    //Вычисление через BCMath
    const TYPE_BC      = 30;

    //@var int тип вычислений которые будут применятся
    protected static $calcType = null;

    /**
     * Установить тип вычислений
     * @param $type
     * @throws Exception если пользователь задал тип отличный от предопределенных
     */
    public static function setType($type)
    {
        if (!in_array($type, [
            self::TYPE_GMP,
            self::TYPE_BC,
            self::TYPE_CLASSIC
        ]))
        {
            throw new Exception('Следующий тип на найден: ' . $type);
        }
        self::$calcType = $type;
    }


    /**
     * Создание объекта производящего вычисления
     * @return BCCalc|ClassicCalc|GMPCalc
     * @throws Exception если пользователь задал тип отличный от предопределенных
     */
    public static function init()
    {
        if (self::$calcType === null)
        {
            self::$calcType = self::TYPE_CLASSIC;
        }

        if (self::$calcType === self::TYPE_CLASSIC)
        {
            include 'ClassicCalc.php';
            return new ClassicCalc();
        }
        elseif (self::$calcType === self::TYPE_BC)
        {
            include 'BCCalc.php';
            return new BCCalc();
        }
        elseif (self::$calcType === self::TYPE_GMP)
        {
            include 'GMPCalc.php';
            return new GMPCalc();
        }

        throw new Exception('Следующий тип на найден: ' . self::$calcType);
    }

    //Суммирует два числа
    abstract public function add($left, $right);

    //Вычитание $right из $left
    abstract public function sub($left, $right);

    //Умножает два числа
    abstract public function mul($left, $right);

    //Деления $left на $right
    abstract public function div($left, $right);

}