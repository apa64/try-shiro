# Grails Shiro practice project

Trying out Shiro features in a Grails 2.2.2 app.

The story so far:

1. grails create-app
1. add shiro:1.2.0-SNAPSHOT dependency
1. grails shiro-quick-start
1. implement login filter to store user permissions in session (work in progress)

## Controller links

* [show debug info](http://localhost:8080/try-shiro/debug)
* [login](http://localhost:8080/try-shiro/auth/login) (joe/password or admin/password)
* [signOut](http://localhost:8080/try-shiro/auth/signOut)
* [assert nativesession](http://localhost:8080/try-shiro/debug/nativesession)
* [permission check "user:read:*"](http://localhost:8080/try-shiro/debug/permission?p=user:read:*)

## Components

* [Grails](http://grails.org/)
* [grails-shiro-plugin](http://grails.org/plugin/shiro)
* [Shiro framework](http://shiro.apache.org/)

## Markdown

* [github-flavored-markdown](https://help.github.com/articles/github-flavored-markdown)
* [markdown syntax](http://daringfireball.net/projects/markdown/syntax)
* [Javascript Markdown renderer](http://www.showdown.im/)
