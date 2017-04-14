//
//  ViewController.swift
//  UIPageViewController
//
//  Created by Cao Xuan Phong on 11/9/16.
//  Copyright © 2016 FioT. All rights reserved.
//

import UIKit

class MyViewController: UIViewController, UIPageViewControllerDataSource {
    var pages = [UIViewController]()
    var pageViewController : UIPageViewController!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.pageViewController = UIPageViewController(transitionStyle: .scroll, navigationOrientation: .horizontal, options: nil)
        self.pageViewController!.view.frame = CGRect(x: 0, y: 0, width: view.frame.size.width, height: view.frame.size.height);
        self.pageViewController.dataSource = self
        
        let page1: UIViewController! = storyboard?.instantiateViewController(withIdentifier: "page1")
        let page2: UIViewController! = storyboard?.instantiateViewController(withIdentifier: "page2")
        
        pages.append(page1)
        pages.append(page2)
        
        self.pageViewController.setViewControllers([page1], direction: UIPageViewControllerNavigationDirection.forward, animated: false, completion: nil)
        
        view.addSubview(pageViewController!.view)
        self.pageViewController!.didMove(toParentViewController: self)
    }
    
    func pageViewController(_ pageViewController: UIPageViewController, viewControllerBefore viewController: UIViewController) -> UIViewController? {
        let currentIndex = pages.index(of: viewController)!
        
        if (currentIndex == 0) {
            return nil
        } else if (currentIndex == 1) {
            return pages[0]
        }
        return nil
    }
    
    func pageViewController(_ pageViewController: UIPageViewController, viewControllerAfter viewController: UIViewController) -> UIViewController? {
        let currentIndex = pages.index(of: viewController)!
        
        if (currentIndex == 1) {
            return nil
        } else if (currentIndex == 0){
            return pages[1]
        }
        
        return nil
    }
    
    func presentationCount(for pageViewController: UIPageViewController) -> Int {
        print(pages.count)
        return pages.count
    }
    
    func presentationIndexForPageViewController(pageViewController: UIPageViewController) -> Int {
        return 0
    }
    
}

