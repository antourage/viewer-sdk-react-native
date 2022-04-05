require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
  s.name         = "AntourageReactNative"
  s.version      = package["version"]
  s.summary      = package["description"]
  s.license      = package["license"]
  s.homepage     = package["homepage"]
  s.authors      = package["author"]
  s.source       = { :git => "https://github.com/antourage/RNAntViewer.git", :tag => "#{s.version}" }
  s.source_files = "ios/**/*.{h,m,mm,swift}"
  s.platforms    = { :ios => "13.0" }
  s.dependency "React"
  s.dependency "Antourage", "~> 4.0.0"
end
