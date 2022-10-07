domains
    intlist=integer*
predicates
    list_exclude_zero(intlist, intlist)
clauses
    list_exclude_zero([], []).
    list_exclude_zero([H|T], [H|R_T]) :- H <> 0, list_exclude_zero(T, R_T).
    list_exclude_zero([0|T], R) :- list_exclude_zero(T, R).

goal
    list_exclude_zero([1, 0, 2, 0, 0, 3, 0], Res).
    %list_exclude_zero(Res, [1, 2, 3]).
    %list_exclude_zero([1, 0, A, 3], [1, 2, 3]).
    %list_exclude_zero([1, A, 2, C, D, B], [1, 2, 3]).
