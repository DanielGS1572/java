var johnHeight = prompt("John´s height");
var friendHeight = prompt("Friend height");

var johnAge= prompt("John´s age");
var friendAge= prompt("Friend age");

if(johnAge*johnHeight >  friendHeight*friendAge){
	prompt("John wins");
}else if(johnAge*johnHeight ===  friendHeight*friendAge){
	prompt("Draw ")
}
else{prompt("Friend wins")
}

