### Prerequisites
1. Install Solr using Docker: https://hub.docker.com/_/solr
2. Java version 8+
3. Maven
4. Java IDE

### Task 1 - Indexing (40 Points)
1. Find collection of the books in English language. It is better to use epub format.
2. Implement indexing process of these books. 
3. Document should have the following fields:
        - Id 
        - Title (book title, string)
        - Authors (collection of strings)
        - Content
        - Language
4. The process of indexing could be described as following:
        - Read all books from local folder
        - Use epubreader library (ex. *com.positiondev.epublib*) for transforming from File to EbubBook object
        - Then transform EpubBook to Book model which represent Solr document
        - Save Books to Solr
5. Implement API endpoint to start indexing process
6. Using spring data solr implement repository to retrieving solr document by id
7. Implement API endpoint
```
GET /api/v1/book/{id}
```

### Task 2 - Search book by query (40 points)
1. Implement API endpoint with following request:
```json
{
  "field": "string", // field for filtering
  "value": "string", // value of the field for filtering
  "facetField": "string", // field for facet
  "fulltext": true, // is full text search
  "q": "string" // query for full text search 
}
```
The response structure is:
```json
{
  "books": [
    {
      "id": "string",
      "authors": [
        "string"
      ],
      "title": "string",
      "language": "string",
      "content": "string",
    }
  ],
  "facets": [
    {
      "valueCount": 0,
      "value": "string",
      "field": {
        "name": "string"
      },
      "key": {
        "name": "string"
      }
    }
  ],
  "numFound": 0
}
```
2. Using *org.springframework.data.solr.core.SolrTemplate * implement search request to Solr using parameters from response

### Task 3 - Implement autosuggestions (20 Point)
1. Implement API endpoint which is returning array of suggestions:
```
 GET api/v1/book/suggest?query=
```
2. Create suggest field in scheme using *org.springframework.data.solr.core.SolrTemplate* which is filled from Book.title & Book.authors
3. Add required searchComponent and requestHandler for suggestions to *solrconfig.xml*
4. Using *org.apache.solr.client.solrj.SolrClient* execute suggest query 
