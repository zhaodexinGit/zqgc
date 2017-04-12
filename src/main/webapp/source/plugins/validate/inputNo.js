function NaNcheckInput(e) {
	// evt = evt ? evt : (window.event ? window.event : null);
	//
	// if (evt.keyCode >=48 && evt.keyCode <=57)
	// return;
	//
	// evt.keyCode = 0;
	var key = window.event ? e.keyCode : e.which;
	if (key == 8)
		return true;
	var keychar = String.fromCharCode(key);
	reg = /\d/;
	return reg.test(keychar);

}
