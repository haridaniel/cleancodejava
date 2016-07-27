# What is pipeline? #
**Pipeline is an implementation of a chain of nodes for processing values asynchronously, that can be configured in an elegant way by fluent interface.**
Similar to java 8 stream api, but with stream api you must have your values in advance (in a collection). So if you don't have them (eg.: you receive values from user input), then you need something else. This is what pipeline chain is, a structure of chained processor nodes and a given output. Then putting values to the pipeline, that will go through it, and triggers the given output (or not if a node filter value out). You can filter, map, peek values like with Streams, but can't aggregate because the value count is infinite, not like Streams.

# A simple example #

```java
Consumer<String> pipeline = Pipeline.ofInputType(String.class)
		.map(s -> s.trim())
		.map(s -> s.toLowerCase())
		.filter(new DuplicateSkipper<>())
		.to(s -> System.out.println(s))
		;
```

## [more info...](http://cleancodejava.com/pipeline-chain/) ##
