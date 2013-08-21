package controllers

import play.api.Play
import play.api.Play.current
import play.api.mvc.Action
import play.api.mvc.AnyContent

object MinifiedAssets extends MinifiedAssetsBuilder

/**
 * Can be used to replace default Assets provided by Play.
 * This version try to return a file WITHOUT '.min' in the name of the file to send the source / non minified version
 * If we don't find non-minified file then we send the minified version as expected
 *
 */
class MinifiedAssetsBuilder extends AssetsBuilder {

  override def at(path: String, file: String): Action[AnyContent] = {

    if (Play.isDev) {

      val devFile = file.replaceAll("""\.min\.""", """\.""");

      val resourceName = Option(path + "/" + devFile).map(name => if (name.startsWith("/")) name else ("/" + name)).get

      val resource = Play.resource(resourceName).getOrElse(NotFound);

      if (resource == NotFound) {
        super.at(path, file)
      } else {
        super.at(path, devFile)
      }

    } else {
      super.at(path, file)
    }

  }

}