 <?php
	 $d = 5;
	 
	 if ($d == 5)
	    echo "5\n";
	 elseif ($d == 6)
	    echo "6\n";
	 else
	    echo "different\n";

	switch ($d) {
		case 5:
			echo "5\n";
			break;
		
		case 6:
			echo "6\n";
			break;

		default:
			echo "different\n";
			break;
	}

?>