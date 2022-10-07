domains
    intlist=integer*
predicates
    list_next(integer, integer, intlist)
clauses
    list_next(A, B, []) :- fail.
    list_next(A, B, [A|[B|T]]) :- !.
    list_next(A, B, [H|T]) :- list_next(A, B, T).

goal
    list_next(5, 6, [1, 4, 5, 6, 0]). % yes
    %list_next(5, 6, [1, 4, 5, 5, 6, 0]). % yes
    %list_next(5, 6, [1, 4, 5, 0, 6, 5]). % no
    %list_next(5, 6, [5, 6, 5, 0, 6]). % yes

    %list_next(6, B, [1, 4, 5, 6, 0]). % yes, B=0
    %list_next(A, B, [1, 4, 5, 6, 0]). % yes, A=1, B=4
    %list_next(A, 7, [1, 4, 5, 6, 0]). % no