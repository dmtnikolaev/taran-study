% Номер варианта - 3
domains
	name=string
predicates
	dog( name )
	parent( name, name )
	grandparent( name, name )
clauses
	dog( X ) :-
		parent( X, Y ), 
		dog( Y ).
		
	dog( "sally" ).
	dog( "bek" ).
	dog( "ban" ).
	dog( "fat" ).
	
	parent( "jek", "sally" ).
	parent( "jek", "bek" ).
	parent( "jim", "bek" ).
	parent( "boss", "jek" ).
	parent( "boss", "jim" ).
	parent( "fat", "ban" ).
	parent( "fat", "jim" ).
	parent( "reks", "boss" ).
	parent( "reks", "fat" ).
	
	grandparent( X, Z ) :-
		parent( X, Y ),
		parent( Y, Z ).
goal
	% Кто является собакой ?
	dog( Who ).
	
	% Кто является родителем ?
	% parent( Who, _ ).
	
	% Кто является внуком (внучкой) ?
	% grandparent( _, Who ).
	
	% Bek - собака ?
	% dog( "bek" ).
	
	% Кто родитель собаки Bek ?
	% parent( Who, "bek" ).
	
	% Кому Bek является родителем ?
	% parent( "bek", Who ).