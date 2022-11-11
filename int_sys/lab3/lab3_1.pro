%count of non 0 elements
DOMAINS
treetype =tree(real, treetype, treetype); empty()
PREDICATES
nondeterm count(treetype,real)
CLAUSES
count(empty,0).

count(tree(Root, Left, Right),L):-  count(Left,LL), count(Right,LR),
					L = LL + LR + 1,Root <> 0.
count(tree(Root, Left, Right),L):-   count(Left,LL), count(Right,LR),L = LL + LR,Root = 0.
					
GOAL
%count(tree(5,tree(-3,tree(6, empty, empty),tree(4, empty, empty)),tree(-10,tree(-2,
%empty, empty),tree(8, empty, empty))),Res).
count(tree(0,tree(3,empty, empty),tree(0,empty, empty)),Res).