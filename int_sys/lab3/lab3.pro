%average of negative nodes
DOMAINS
treetype =tree(real, treetype, treetype); empty()
PREDICATES
nondeterm sum(treetype,real)
nondeterm average_minus(treetype,real)
nondeterm count(treetype,real)
CLAUSES
count(empty,0.0).
count(tree(Root, Left, Right),L):-  count(Left,LL), count(Right,LR),L = LL + LR + 1, Root < 0.
count(tree(Root, Left, Right),L):-   count(Left,LL), count(Right,LR),L = LL + LR, Root >= 0.


						
sum(empty,0.0).
sum(tree(Root, Left, Right),S) :-   sum(Left,SL), sum(Right,SR),S = SL + SR + Root, Root < 0.
sum(tree(Root, Left, Right),S) :-  sum(Left,SL), sum(Right,SR),S = SL + SR, Root >= 0.
					
average_minus(empty,0.0):- !.
average_minus(Tree,R):- count(Tree,L), sum(Tree,S), L > 0, R=S/L.
GOAL
%average_minus(tree(5,tree(-3,tree(6, empty, empty),tree(4, empty, empty)),tree(-10,tree(-2,
%empty, empty),tree(8, empty, empty))),Res).
%average_minus(tree(-5,tree(3,empty, empty),tree(10,empty, empty)),Res).
average_minus(tree(5.0,tree(-3.0,tree(6.0, empty, empty),tree(4.0, empty, empty)),tree(-10.0,tree(-2.0,
empty, empty),tree(8.0, empty, empty))),Res).