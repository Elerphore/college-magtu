<?php

//Класс предназначен для совершения математических операций методами PHP BCMath

class BCCalc extends FlexibleCalc
{
    //@var int определяет точность после запятой для BCMath
    public static $scale = 8;

    public function add($left, $right)
    {
        return bcadd($left, $right, self::$scale);
    }

    public function div($left, $right)
    {
        return bcdiv($left, $right, self::$scale);
    }

    public function mul($left, $right)
    {
        return bcmul($left, $right, self::$scale);
    }

    public function sub($left, $right)
    {
        return bcsub($left, $right, self::$scale);
    }
}