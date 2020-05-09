<?php

header("Content-type: text/html;charset=utf-8");

if (sizeof($_POST)!=0){

	$link = mysqli_connect("127.0.0.1", "root", "root", "megaapp");

	if (!$link) {
		echo "ERROR: " . mysqli_connect_error() . mysqli_connect_errno() . "<br>";
		exit;
	}
	
	$ul = mysqli_real_escape_string ($link, $_POST['ul']);
	$up = sha1($_POST['up']);
	
	$r = mysqli_query($link, "SELECT * from `users` where `user_login`='$ul' AND `user_password`='$up' limit 1");
	
	$txt = "<p align='center' style='font-size:30px'>%s</p>";


	if (mysqli_num_rows($r)==1) {
		echo sprintf($txt,'User exists!');
	} else {
		echo sprintf($txt,'No such user in database found :(');
	}

	echo file_get_contents('form_back.tpl');
	
	mysqli_close($link);
	
} else {
	$form = file_get_contents('form.tpl');
	$form = str_replace('{PAGE_URL}', $_SERVER['PHP_SELF'], $form);
	echo $form;
}

?>
