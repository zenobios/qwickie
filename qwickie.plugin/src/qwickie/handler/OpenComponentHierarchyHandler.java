package qwickie.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class OpenComponentHierarchyHandler extends AbstractHandler
{	
	private class DefaultSearchRequestor extends SearchRequestor 
	{
		private List<SearchMatch> matches = new ArrayList<SearchMatch>();
		
		@Override
		public void acceptSearchMatch(SearchMatch match) throws CoreException
		{
			matches.add(match);
		}
		
		public List<SearchMatch> getMatches()
		{
			return matches;
		}
	
	}

	public Object execute(ExecutionEvent event) throws ExecutionException
	{
		IStructuredSelection currentSelection = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);
		Object selectedElement = currentSelection.getFirstElement();
		if(selectedElement instanceof ICompilationUnit)
		{
			SearchPattern searchPattern = SearchPattern.createPattern((IJavaElement) selectedElement, 
					IJavaSearchConstants.CLASS_INSTANCE_CREATION_TYPE_REFERENCE);
			SearchEngine searchEngine = new SearchEngine();
			try
			{
				DefaultSearchRequestor requestor = new DefaultSearchRequestor();
				searchEngine.search(searchPattern, new SearchParticipant[] {SearchEngine.getDefaultSearchParticipant()}, 
						SearchEngine.createWorkspaceScope(), requestor, null);
				
				List<SearchMatch> matches = requestor.getMatches();
				if(matches.isEmpty())
				{
					System.err.println("No matches found");
				}
				else
				{
					for (SearchMatch searchMatch : matches)
					{
						System.err.println("Match: " +searchMatch);
					}
				}
			} catch (CoreException e)
			{
				e.printStackTrace();
			}
			System.out.println("Computing hierarchy of " +((ICompilationUnit)selectedElement).getElementName());
		}
		return null;
	}

}
