## Jira Utility Pack

This is a plugin project for [Atlassian Jira](https://www.atlassian.com/software/jira).
Despite it's name, this project is just a collection of goofy modules, used only to
demonstrate some of the basic functions and customizations that a plugin can do.

## What's included?

* The **D&D Alignment Custom Field Type**, that allows the user to create a
  custom field to store the issue's [alignment](http://en.wikipedia.org/wiki/Alignment_%28Dungeons_%26_Dragons%29).
  This is done using **two** input-select elements. When in `display` mode,
  each alignment is displayed using a different color and a link to see an
  `Alignmen Chart` is shown to the user.
* A new **Planning menu** with various items in different categories. All
  itens link to external sites.
* The **Quote of the issue** panel on the `View Issue` page. This panel
  shows a random quote from [IHeartQuotes](http://iheartquotes.com)
  everytime the page is refreshed.
* The **What to do?** menu item. This item appears on the `View Issue`
  page (together with the `Move`, `Link`, etc. commands) and when clicked
  shows a new page (on a popup window) that analyzes the value of the
  `Alignment` (assuming it does exist) and tell the user what is the best
  course of action do to.
* The **Psychiatric help** menu item under the `User` menu. This opens a popup
  window that let you talk to [ELIZA](http://www.masswerk.at/elizabot/) about
  your feelings.

## How to use it?

To build the plugin, you should first install the [Atlassian SDK](https://developer.atlassian.com/display/DOCS/Set+up+the+Atlassian+Plugin+SDK+and+Build+a+Project).
If you only want to run/build the plugin, just use the atlas commnands (e.g. `atlas-run`,
`atlas-debug`, etc.).

However, if you *do* want to fiddle a bit with the source using an IDE, you can run
the command `atlas-mvn eclipse:eclipse`, which will generate all of the eclipse-specific
trash needed to make the project "importable". Now, open [Eclipse](http://www.ldoceonline.com/Computers-topic/memory-hog)
and have fun!

## License

BSD-3. For more details, take a look at `LICENSE`.

Most of the resources (images, links, etc.) used are from a lot of different sources
on the internet; I'm not the owner or have any affiliation to any of that. The material
used only for demonstration purposes.
