domains
	name=string
predicates
	dog( name )
	parent( name, name )
clauses
	dog( X ) :- parent( X, Y ), dog( Y ).
	dog( "reks" ).
	parent( "jek", "reks" ).
goal
	dog( Who ).
