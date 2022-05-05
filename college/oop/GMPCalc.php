<?php

//Класс предназначен для совершения математических операций методами PHP GMP
class GMPCalc extends FlexibleCalc
{

    public function add($left, $right)
    {
        return gmp_add($left, $right);
    }

    public function div($left, $right)
    {
        return gmp_div($left, $right);
    }

    public function mul($left, $right)
    {
        return gmp_mul($left, $right);
    }

    public function sub($left, $right)
    {
        return gmp_sub($left, $right);
    }
}