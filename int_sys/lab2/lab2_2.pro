domains
    intlist=integer*
predicates
    list_len_exl(integer, intlist, integer)
clauses
    list_len_exl(_, [], 0).
    list_len_exl(X, [X|T], L) :- list_len_exl(X, T, L).
    list_len_exl(X, [H|T], L) :- list_len_exl(X, T, Nl), L = Nl + 1, X <> H.

goal
    list_len_exl(1, [1, 2, 1, 3, 1], Len).
    %list_len_exl(X, [1, 2, 3], 2).

