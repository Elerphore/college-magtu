<?php require 'FlexibleCalc.php'; ?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="" method="GET">
        Тип калькулятора: <select name="type" id="type">
            <option value="TYPE_GMP">TYPE_GMP</option>
            <option value="TYPE_BC">TYPE_BC</option>
            <option value="TYPE_CLASSIC">TYPE_CLASSIC</option>
        </select>
        <br>
        Тип Фигуры: <select name="fig_type" id="fig_type">
            <option value="TYPE_GMP">Square</option>
            <option value="TYPE_BC">Circle</option>
        </select>
        <br>
        Площадь:<input type="number" name="first_value" id="first_value">
        <br>
        Периметр:<input type="number" name="second_value" id="second_value">
        <br>
        <button type="submit">Send</button>
    </form>
</body>
</html>

<?php 
    $type;

    if(isset($_GET['type'])) {
        switch($_GET['type']) {
            case 'TYPE_GMP':
                $type = FlexibleCalc::TYPE_GMP;
                break;
            case 'TYPE_BC':
                $type = FlexibleCalc::TYPE_BC;
                break;
            case 'TYPE_CLASSIC':
                $type = FlexibleCalc::TYPE_CLASSIC;
                break;
        }

        FlexibleCalc::setType($type);

        $fcalc = FlexibleCalc::init();

        $left  = $_GET['first_value'];
        $right = $_GET['second_value'];

        echo '<br>';
        echo "Left: {$left}, Right: {$right}" . '<br>';
        echo('Add: ' . $fcalc->add($left, $right)) . '<br>';
        echo('Sub: ' . $fcalc->sub($left, $right)) . '<br>';
        echo('Mul: ' . $fcalc->mul($left, $right)) . '<br>';
        echo'Div: '.($fcalc->div($left, $right)) . '<br>';
    }
?>