<?php

//Класс предназначен для совершения математических операций стандартными методами PHP

class ClassicCalc extends FlexibleCalc
{
    
    public function add($left, $right)
    {
        return $left + $right;
    }

    public function div($left, $right)
    {
        return $left / $right;
    }

    public function mul($left, $right)
    {
        return $left * $right;
    }

    public function sub($left, $right)
    {
        return $left - $right;
    }
}