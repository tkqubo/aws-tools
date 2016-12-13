package jkugiya.awstools.signer.v4

import java.net.{ URI, URLEncoder }

case class HttpRequest(method: String, uri: URI) {

  val path =
    if (uri.getPath.isEmpty) "/"
    else {
      "/" +
        URLEncoder.encode(uri.getPath.substring(1, uri.getPath.length), "UTF-8")
        .replaceAll("\\*", "%2A")
    }

  val query =
    Option(uri.getQuery).getOrElse("")
}
