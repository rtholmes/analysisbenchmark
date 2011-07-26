This is a simple project for testing static and dynamic analyses to ensure the adequately cover various common and corner cases.

-------------------------
AnalysisBenchmark
-------------------------

	TODO
	
ANT Tasks
-------------------------

	**clean**
		cleans the project

	**compile**
		complies the sample code, sample tests, and validation code

	**iiStatic**
		performs the static analysis

	**weave**
		weaves the code so the dynamic analysis can be performed

	**iiDynamic**
		performs the dynamic analysis

	**validate**
		validates the results of the dynamic and static analyses against known oracles for the sample system

Instructions
-------------------------

	To validate a change:
		1) ``ant clean``
		2) ``ant compile``
		3) ``ant iiStatic``
		4) ``ant weave``
		5) ``ant iiDynamic``				
		6) ``ant validate``		

	If you have your own static / dynamic files you can copy them into the correct locations and just run ``ant validate``.

	TODO: Create developer documentation for validating changes to ``depfind_uw`` and ``dynamictracer``.
	
