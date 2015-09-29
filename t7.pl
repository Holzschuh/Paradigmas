% 1.
pred([],[]). 
pred([H|T],[H1|T1]) :- H1 is H + 1, pred(T,T1).

% Verifica se a segunda lista contém os elementos da primeira lista + 1

% ?­ pred([1,2,3],[a,b,c]). -> false.
% ?­ pred([8,9],L).         -> L = [9,10].
% ?­ pred([1,2,3],[2,L]).   -> false
% ?­ pred([1,2],[2,X]).     -> X = 3

% 2.
ziplus([],[],[]).
ziplus([H1|T1], [H2|T2], [H|T]) :- H is H1 + H2, ziplus(T1,T2,T).

% 3.
countdown(-1,[]).
countdown(N,[H|T]) :- H is N, Aux is N-1, countdown(Aux, T).

% 4.
potencia(N, L) :- A is 0, potenciaa(A, N, L).

potenciaa(_, 0, []).
potenciaa(M, N, [H|T]) :- H is 2^M, M1 is M+1, N1 is N-1, potenciaa(M1, N1, T).

% 5.
positivos([],[]).
positivos([H1|T1], [H2|T2]) :-
(H1 > 0 -> H2 is H1, positivos(T1, T2);
 positivos(T1,[H2|T2])
).
